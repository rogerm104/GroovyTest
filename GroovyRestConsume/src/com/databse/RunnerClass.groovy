package com.databse
import javax.sql.DataSource

import groovy.sql.GroovyResultSet
import groovy.sql.Sql
class RunnerClass {

	public static PritResults(DataSource ds) {
		def ids
		def sql = Sql.newInstance(ds)
		Sql.withInstance(ds) {
			ids = sql.executeInsert """
			INSERT INTO groovyTest (NAME, URL) VALUES ('tutorials', 'github.com/eugenp/tutorials')
			"""}
		println ids[0][0]
	}
}
