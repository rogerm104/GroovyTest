package com.restinterface

def url = new URL('https://hooks.zapier.com/hooks/catch/3320164/az95by')
def connection = url.openConnection()
connection.requestMethod = 'GET'
if (connection.responseCode == 200) {
  println connection.content.text
  println connection.contentType
  println connection.lastModified
  connection.headerFields.each { println "> ${it}"}
} else {
}