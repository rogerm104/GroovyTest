package com.databse
import groovy.sql.GroovyResultSet
import groovy.sql.Sql

//def sql = Sql.newInstance('jdbc:sqlserver://localhost:1433;databaseName=groovy;integratedSecurity=true;','sa2', 'prAtik92@', 'com.microsoft.sqlserver.jdbc.SQLServerDriver')
//def q1 = "SELECT Type,Description FROM A.dbo.Type"

Map dbConnParams = [
	url: 'jdbc:sqlserver://localhost:1433;databaseName=groovy;integratedSecurity=true',
	user: 'sa2',
	password: 'prAtik92@',
	driver: 'com.microsoft.sqlserver.jdbc.SQLServerDriver']

def sql = Sql.newInstance(dbConnParams)

def insertoperation= {
	def ids
	Sql.withInstance(dbConnParams) {
		ids = sql.executeInsert """
  INSERT INTO groovyTest (NAME, URL) VALUES ('tutorials', 'github.com/eugenp/tutorials')
"""}
	println ids[0][0]
}


def updateOperation= {
	def count
	sql.withInstance(dbConnParams) {
		count = sql.executeUpdate("UPDATE groovyTest SET URL = 'https://  URL'");
	}
	println count
}


def selectOperation = {
	sql.eachRow("SELECT * FROM groovyTest") { GroovyResultSet rs ->
		println rs.getString("ID") + " "+ rs.getString("URL") +" "+rs.getString("NAME");
		println rs.ID;

	}
}

selectOperation.run();



//sql.close()