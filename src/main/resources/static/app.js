var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/rider');
    stompClient = Stomp.over(socket);
    stompClient.connect({token: 'token'}, function (frame) {
        setConnected(true);
//        var headerName = "${_csrf.headerName}";
//        var token = "${_csrf.token}";
//        var headers = {};
//        headers[headerName] = token;
        var sessionId = /\/([^\/]+)\/websocket/.exec(socket._transport.url)[1];

        console.log('Connected: ' + frame);
        stompClient.subscribe('/user/queue/cab-booking', function (bookingDetails) {
                console.log(JSON.parse(bookingDetails.body));
                showGreeting(JSON.parse(bookingDetails.body).cabDetails.cabNumber);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/book-cab", {},
    JSON.stringify({
        'riderId': $("#name").val(),
        'pickupLocation' : {'x': $("#src_latitude").val(), 'y': $("#src_longitude").val()},
        'dropLocation' : {'x': $("#des_latitude").val(), 'y': $("#des_longitude").val()},
    }));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});