package com.dxw.transfer;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.BiConsumer;

public class TransferUtil {

    private TransferUtil() {

    }

    private static TransferUtil instance = new TransferUtil();

    private static Map<String, BiConsumer> functionMap = new HashMap<>();

    public static <S,T> void register(Class<S> sourceClz, Class<T> targetClz, BiConsumer<S,T> f){
        functionMap.put(getPathkey(sourceClz,targetClz),f);
    }

    @SneakyThrows
    public static <T> T to(Object source, Class<T> tClass){
        if(tClass==null){
            throw new Exception("target class cloud not be null!");
        }
        T target = tClass.newInstance();
        instance.transfer(source, target);
        return target;
    }

    @SneakyThrows
    public static <T,S> List<T> to(List<S> sourceCollection, Class<T> tClass){
        if(tClass==null){
            throw new Exception("target class cloud not be null!");
        }
        List<T> targetList = new ArrayList<>();
        for(S source:sourceCollection){
            T target = to(source, tClass);
            targetList.add(target);
        }
        return targetList;
    }

    @SneakyThrows
    private static void transfer(Object source, Object target) {
        Map<String, Object> sourceMap = new HashMap<>();
        for (Field field : source.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(source);
            sourceMap.put(field.getName(),value);
        }
        for(Field field : target.getClass().getDeclaredFields()){
            boolean accessible = field.isAccessible();
            field.setAccessible(true);
            Object value = sourceMap.get(field.getName());
            if(value!=null) {
                field.set(target,value);
            }
            field.setAccessible(accessible);
        }
        BiConsumer f = functionMap.get(getPathkey(source.getClass(), target.getClass()));
        if(f!=null){
            f.accept(source, target);
        }
    }

    private static String getPathkey(Class sourceClz, Class targetClz){
        return sourceClz.getName()+"_"+targetClz.getName();
    }

}
