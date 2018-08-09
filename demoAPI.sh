#! /bin/bash
# /usr/local/bin/demoAPI
#

function d_start(){
	echo "demoAPI : Starting service"
	java -jar target/DemoAPi-0.0.1-SNAPSHOT.jar
}

function d_stop( ) 
{ 
	echo  "Deluge: stopping Service (PID = $(pgrep java) )" 
	kill $(pgrep java)
	#rm  /tmp/demoAPI.pid
 }
 
function d_status( ) 
{ 
	echo "PID is $(pgrep java)"
}

# Some Things That run always 
touch  /var/lock/demoAPI

# Management instructions of the service 
case "$1" in 
	start )
		d_start
		;; 
	stop )
		d_stop
		;; 
	reload )
		d_stop
		sleep  1
		d_start
		;; 
	status )
		d_status
		;; 
	* ) 
	echo  "Usage: $0 {start | stop | reload | status}" 
	exit 1 
	;; 
esac
 
exit 0
