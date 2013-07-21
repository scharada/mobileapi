
var WebSocketServer = require('ws').Server
, wss = new WebSocketServer({port: 80});

var clients = [];

wss.on('connection', function(ws) {
      clients.push(ws);
          ws.on('message', function(message) {
              console.log('received: %s', message);
                       for (var i=0; i < clients.length; i++) {
                          clients[i].send(message, function(error) {
                                });
                        }
 });

  wss.on('close', function(connection) {
          clients.remove(connection);
  });

});

