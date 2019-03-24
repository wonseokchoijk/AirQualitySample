package com.wonsch.sentoze.airqualitysample.dto

class Model {
    lateinit var status: String
    lateinit var data: Data

    class Data {
        lateinit var aqi: String
        lateinit var idx: String
        lateinit var attributions: List<Attribution>
        lateinit var city: City
        lateinit var dominentpol: String
        lateinit var iaqi: Iaqi
        lateinit var time: Time

        class Attribution {
            lateinit var url: String
            lateinit var name: String
        }

        class City {
            lateinit var geo: List<Double>
            lateinit var name: String
            lateinit var url: String
        }

        class Iaqi {
            lateinit var co: Value
            lateinit var h: Value // 取得される場合とされない場合があるらしい。
            lateinit var no2: Value
            lateinit var o3: Value
            lateinit var pm10: Value
            lateinit var pm25: Value
            lateinit var so: Value
            lateinit var w: Value
            lateinit var wg: Value

            class Value {
                lateinit var v: String
            }
        }

        class Time {
            lateinit var s: String
            lateinit var tz: String
            lateinit var v: String
        }
    }
}