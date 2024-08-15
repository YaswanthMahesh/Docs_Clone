var socket = new SockJS('/ws'); // Connect to the WebSocket endpoint
var stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) {
    console.log('Connected: ' + frame);

    // Subscribe to the topic to receive broadcast messages
    stompClient.subscribe('/topic/messages', function (message) {
        console.log('Received: ' + message.body);
        document.getElementById('editor').value = message.body;
    });
});

function sendMessage() {
    var message = document.getElementById('editor').value;
    stompClient.send("/app/message", {}, message); // Send message to the server
}

document.getElementById('editor').addEventListener('input', sendMessage);

//const socket = new WebSocket('ws://localhost:8080/ws');
//
//socket.onopen = function(event){
//    alert('You are Connected to WebSocket Server');
//};
//
//socket.onmessage = function(event){
//    const outputDiv = document.getElementById('editor');
//    outputDiv.innerHTML += `<p><b>"${event.data}"</b></p>`;
//}
//
//socket.onclose = function (event) {
//    console.log('Disconnected from WebSocket server');
//};
//
//function sendMessage() {
//    const messageInput = document
//        .getElementById('editor');
//    const message = messageInput.value;
//    socket.send(message);
//}
//
