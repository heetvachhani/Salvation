'use strict';

const express = require('express');
const path = require('path');
const exphbs  = require('express-handlebars');
const initHttpServer = require('./routes/api').initHttpServer
const connectToPeers = require('./routes/api').connectToPeers
const initP2PServer = require('./routes/api').initP2PServer
const initialPeers = process.env.PEERS ? process.env.PEERS.split(',') : [];

const app = express();


app.engine('handlebars', exphbs({defaultLayout: 'main'}));
app.set('view engine', 'handlebars');

app.use(express.static('public'))

app.use('/', require('./routes/index'))


connectToPeers(initialPeers);
initHttpServer(app);
initP2PServer();
