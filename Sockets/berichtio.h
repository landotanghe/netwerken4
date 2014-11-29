#ifndef _BERICHTIO_H_
#define _BERICHTIO_H_

#include <iostream>
#include <string>

// Klasse voor de communicatie tussen sockets.
// Berichten worden afgesloten door een vaste delimiter (bv. "\n\n").
// Schrijven/inlezen wordt zonodig herhaald tot volledig bericht
// verstuurd/ontvangen is.
class BerichtIO
{
protected:
	int _in_fd;
	int _out_fd;
	int _maxlen;
	std::string _delimiter;
	std::string _totbuffer;  // concatentatie van buffers
	char *_buf;
	int _buflen;

	
	virtual void lees_buffer()
	{
		// ...
		
		std::cerr << "IO:lees_buffer:[" << std::string(_buf, n) << "]" << std::endl;
	}
public:

	// in_fd_ is socket descriptor voor inlezen
	// out_fd_ is socket descriptor voor uitschrijven
	// delimiter is vaste afsluiter voor berichten
	// buflen_ is de lengte van de IO-buffer
	// maxlen_ is de maximum lengte van een bericht
	BerichtIO(int in_fd_, int out_fd_, const std::string &delimiter_, int buflen_ = 1024, int maxlen_ = 32768)
	: _in_fd(in_fd_), _out_fd(out_fd_), _delimiter(delimiter_), _maxlen(maxlen_), _buflen(buflen_)
	{
		_buf = new char[buflen_];
	}
	
	~BerichtIO()
	{
		delete [] _buf;
	}

	virtual void verstuur_bericht(const std::string &bericht)
	{
		std::cerr << "IO:verstuur:[" << bericht << "]" << std::endl;

		// ...
	}

	virtual std::string ontvang_bericht()
	{
		// ...
		// while ( ...)
		// {
		//    ...
		// 32
		std::cerr << "IO:" << n << " bytes gelezen" << std::endl;
		//    ...
		// }
		// ...
		std::cerr << "IO:ontvang:[" << res << "]" << std::endl;
		return res;
	}


};

#endif
