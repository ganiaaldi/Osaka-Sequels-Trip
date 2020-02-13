package com.aldi.osakasequelstrip.Adapter

class Endpoint {

    companion object {

        private val SERVER = "http://192.168.43.11/dbosakast/"
        val CREATE = SERVER+"create.php"
        val READ = SERVER+"read.php"
        val DELETE = SERVER+"delete.php"
        val UPDATE = SERVER+"update.php"
    }
}