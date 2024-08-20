var socket = new SockJS('/ws'); // Connect to the WebSocket endpoint
var stompClient = Stomp.over(socket);
//var doc;

stompClient.connect({}, function (frame) {
    console.log('Connected: ' + frame);

    // Subscribe to the topic to receive broadcast messages
    stompClient.subscribe('/topic/messages', function (message) {
        console.log('Received: ' + message.body);
        document.getElementById('editor').value = message.body;
    });

    stompClient.send("/app/getState",{});
});

function sendMessage() {
    var message = document.getElementById('editor').value;
    stompClient.send("/app/message", {}, message); // Send message to the server
}

// Make a GET request
function apiCall(url,requestOptions) {
    (requestOptions == null ? fetch(url) : fetch(url,requestOptions))
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(data => {
        console.log(data);
        doc = data;
        document.getElementById('editor').value = data.content;
      })
      .catch(error => {
        console.error('Error:', error);
      });
}



function save() {
    doc.content = document.getElementById('editor').value;
    const requestOptions = {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(doc),
    };
    apiCall('http://localhost:8080/UpdateDoc',requestOptions);
    sendMessage(); // Send message to the server
}

document.getElementById('editor').addEventListener('input', sendMessage);
apiCall('http://localhost:8080/Docs/1',null);


