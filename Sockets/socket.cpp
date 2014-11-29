#include <iostream>
#include <string>
#include <stdexcept>
#include <sys/socket.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <cstring>
#include <cerrno>
#include "socket.h"

using namespace std;

int main(){
	short poort = 13;
	
	maak_adres_ipv4("www.facebook.com", poort, SOCK_STREAM );
	return 0;	
}
