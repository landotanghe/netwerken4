#ifndef _SOCKET_H_
#define _SOCKET_H_

#include <iostream>
#include <sstream>
#include <string>
#include <stdexcept>
#include <sys/socket.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <cstring>
#include <cerrno>

template <typename T>
std::string to_string(const T &x) 
{
	std::ostringstream os;
	os << x;
	return os.str();
}

struct NetwerkExceptie: public std::runtime_error
{
	NetwerkExceptie(const std::string &s) 
	: std::runtime_error(s)
	{}
};

in_addr** getaddrinfo(const char *name){
	hostent* host = gethostbyname(name);
	return (in_addr**) host->h_addr_list;
}

//Maakt een IPv4 socket-adres aan de hand van gegeven 'hostnaam' (bv. "localhost" of "www.example.net") en 'poort'.
//Het derde argument is SOCK_STREAM of SOCK_DGRAM
// throws NetwerkExceptie bij problemen.
sockaddr_in maak_adres_ipv4(const std::string &servernaam, short poort, int socktype)
{
    //maak gebruik van getaddrinfo
    //print alle addressen van getaddrinfo uit, gebruik het eerste uit de lijst als returnwaarde
    sockaddr_in s_adres;
    memset(s_adres,0,sizeof(s_adres));
    s_adres.sin_family = AF_INET;
    
    in_addr** in_adressen = getaddrinfo(servernaam.c_str());
}

//idem voor ipv6
sockaddr_in6 maak_adres_ipv6(const std::string &servernaam, short poort, int socktype)
{
}


// Maakt een standaard tcp-socket (IPv4 en streaming) en geeft descriptor terug. 
// throws NetwerkExceptie indien dit niet lukt.
int maak_tcp_socket()
{
    
}

// Sluit de socket met descriptor sd.	
// throws NetwerkExceptie indien dit niet lukt.
void sluit(int sd)
{
}


// Maakt een IPv4 server-adres dat luistert op de gegeven 'poort' (op alle netwerkinterfaces, TCP socket).
// Kan je gebruik maken van de methode maak_adres_ipv4, of moet je manueel een struct invullen?
sockaddr_in maak_server_adres_ipv4(short poort)
{

    
}

// idem voor ipv6
sockaddr_in6 maak_server_adres_ipv6(short poort)
{
}

//configureer de socket zodat het adres kan hergeberuikt worden
void set_hergebruik_adres(int fd){
}

// Laat server-socket (descriptor sd) luisteren op de gegeven poort (max. 10 connecties). 
// IPv4, TCP sockets
// throws NetwerkExceptie indien er een fout optreedt.
void verbind_en_luister(int sd, short poort) 
{ 
}

// Laat server-socket (descriptor sd) wachten op een client die wil connecteren.
// Return de socketdescriptor van de client.
// throws NetwerkExceptie indien er een fout optreedt.
int accepteer(int sd) 
{
}


//Probeert client-socket (descriptor sd) te connecteren met gegeven adres
// throws NetwerkExceptie indien er een fout optreedt.
void connecteer(int fd, const sockaddr_in & adres){
}

//idem, maar op servernaam
void connecteer(int fd, const std::string &servernaam, short poort)
{
}

// Probeert string 's' te schrijven naar socket met descriptor 'sd'.
// Return aantal effectief uitgeschreven.
// throws NetwerkExceptie indien er een fout optreedt. 
int schrijf(int fd, const std::string &s) 
{
}

// Probeert 'buflen' karakters in te lezen in 'buffer' uit socket met descriptor 'sd'.
// Return aantal effectief ingelezen.
// throws NetwerkExceptie indien er een fout optreedt. 
int lees(int fd, char *buffer, int buflen)
{
}

#endif
