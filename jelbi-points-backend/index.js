const express = require('express')
const cors = require('cors')
const uuid = require('uuid/v4')
const axios = require('axios')

require('dotenv').config()

var app = express()

app.use(cors())

app.use(express.urlencoded());
app.use(express.json());

app.post('/', (req, res, next) => {
  bliq(req.body)
    .then(data => data.data)
    .then(result => res.json(result))
    .catch(e => res.json(e))
})

app.listen(8080)


const bliq = (coords) => {
  const url = 'https://api.bliq.ai:443/park/v2/getOnStreetParkingOptions'
  const headers = {
    apikey: process.env.APIKEY,
    uuid: uuid()
  }
  const data = {
    "mapLayers": [
      "RULES",
      "PREDICTION"
    ],
    "outputFormat": "GEO_JSON",
    "mapResolutionLevel": "BLOCK",
    "requestType": {
      "dataType": "PolygonRequest",
      "value": {
        "type": "Polygon",
        "coordinates": coords
      }
    }
  }

  return axios({
    method: 'POST',
    url,
    data,
    headers
  })
}