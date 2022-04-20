function sseRequest(){
    var source = new EventSource('http://localhost:9001/sse/get');
    source.onmessage = (e)=>{

    };
    source.addEventListener('eventData', (e)=> {
        console.log(e.data);
        var eventObj = JSON.parse(e.data);
        document.getElementById('event').innerHTML = eventObj.count + '/' + eventObj.total;
    });
    source.addEventListener('eventResult', (e)=> {
        console.log(e.data);
        var eventObj = JSON.parse(e.data);
        document.getElementById('event').innerHTML = e.data;
    });
    source.addEventListener('error', (e)=>{
        if (event.readyState == EventSource.CLOSE) {
            console.log(e.data);
        }else{
            console.log(e.data);
        }
        event.target.close();
    });
}
