const express = require('express');
const router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('onboard');
});

router.get('/onboard', function(req, res, next) {
  res.render('onboard');
});

router.get('/view', function(req, res, next) {
  res.render('view');
});

module.exports = router;
