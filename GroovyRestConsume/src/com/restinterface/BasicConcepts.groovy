/**
 * 
 */
package com.restinterface

/**
 * @author ROGER
 *
 */
class BasicConcepts {

	/**
	 * @param args
	 */
	static void main(args) {

		def basic= {
			def i=9.0;
			println "The variable i belongs to  "+i.getClass();
			def fncall = {println " this is a closure" };
			fncall.call();
			assert 1+1==2
			assert 1.1.plus(1.1) == 2.2
		}


		def loopsCounter= {

			for (def j=0;j<10;j++) {
				println j
			}
			println "_______________________"

			for (j in 5..-5) {
				println j
			}
			println "_______________________"

			5.upto(10) {println "$it" }
			5.times { println "Priting for the $it 'th thimes" }
			1.step(10, 2) { println "The current step is $it 'th "  }

			def addressMap= ["House No":"569","Street":"Forgottem", "Village":"Goa-Velha","PIN":"403108"];

			for(e in addressMap) {
				println "The Key is :"+e.key
				println "The Val is :"+e.value
			}



		}

		def Strings= {

			def myString = "This is world and it is beautiful";
			println "test " + myString;
			println myString[0..3]
			println myString[5..13]
			println myString[3,5,14]

			println myString.toList()

			String s= $/ hello
			how are you dear
			/$
			println s.replace("\n", "")

		}
		def realClosure = {pram1-> println "This is how you display $pram1"
			def range = 1..20;
			println range.getFrom()
			println range.getTo()
		}

		realClosure.call("a Real Closure");



	}
}
