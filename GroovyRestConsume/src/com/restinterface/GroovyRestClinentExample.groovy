package com.restinterface

@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7')
@Grab('oauth.signpost:signpost-core:1.2.1.2')
//@Grab('oauth.signpost:signpost-commonshttp4:1.2.1.2')
 
import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.*
 
def twitter = new RESTClient( 'https://api.twitter.com/1.1/statuses/' )
// twitter auth omitted
 
try { // expect an exception from a 404 response:
    twitter.head path: 'public_timeline'
    assert false, 'Expected exception'
}
// The exception is used for flow control but has access to the response as well:
catch( ex ) { assert ex.response.status == 404 }
 
assert twitter.head( path: 'home_timeline.json' ).status == 200