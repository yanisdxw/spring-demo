<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Hello World !</title>
</head>
<body>
<h2>Hello World!</h2>
<button onclick="sseRequest()">Start</button>开始下载
<div id="event"></div>
</body>
<script>
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
        document.getElementById('event').innerHTML = e.data;
    });
    source.addEventListener('error', (e)=>{
        if (event.readyState == EventSource.CLOSE) {
            console.log('connection is close');
        }else{
            console.log('connection is close');
        }
        event.target.close();
    });
}
</script>

</html>