export default = {
  "temperature": getTemperature(),
  "co2": getCo2Emission(),
  "nitrogen": getNitrogen(),
  "condition": getWeatherCondition()
}

function getWeatherCondition() {
  var myArray = ['Sunny', 'Cloudy', 'Rainy', 'Thunderstorm', 'Sunny', 'Cloudy', 'Sunny', 'Windy'];
  var randCond = myArray[Math.floor(Math.random() * myArray.length)];
}

function getTemperature() {
  return Math.floor(Math.random()*(94-47+1)+47);
}

function getCo2Emission() {
  return Math.floor(Math.random()*(89-60+1)+60);
}

function getNitrogen() {
  return Math.floor(Math.random()*(60-30+1)+30);
}
