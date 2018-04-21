'use strict';

const express = require('express');
const path = require('path');
var exphbs  = require('express-handlebars');
var initHttpServer = require('./routes/api').initHttpServer
var connectToPeers = require('./routes/api').connectToPeers
var initP2PServer = require('./routes/api').initP2PServer

var initialPeers = process.env.PEERS ? process.env.PEERS.split(',') : [];

const app = express();
app.engine('handlebars', exphbs({defaultLayout: 'main'}));
app.set('view engine', 'handlebars');


connectToPeers(initialPeers);
initHttpServer(app);
initP2PServer();
