# RMI-Dictionary-Service
> Module: Distibuted Systems  
> Lecturer: Partick Mannion  
> 40% Project: RMI Dictionary Service  

## An Asynchronous RMI Dictionary Service  
For the distributed systems module we are required to build an application using Java and Apache Tomcat to return the meaning of a word from the dictionary that was entered by the user.

## The Requirements  
The  minimum requirements for this project, the implementation of the dictionary lookup service, should use the Servlet/JSP and Java RMI frameworks to develop a remote, ansynchronous dictionary lookup service. The minimum requirement are as follows:
1. A web client request should be placed in a message queue to await processing. Each request should be allocated a job number. The job number should be added to an inQueue(map) along with the request string. The servlet handler should return the job number to the client which in turn should poll the server every 10 seconds for a response. When a response is recicved with a completed task, the result of the dictionary lookup should be displayed in the browser.
2. An interface called DictionaryService should expose a remote method with the following signature:
'public String lookup(String s) throws RemoteException;' 
where 's' is the string lookup in the dictionary, and the String returned is either the dictionary definition od s or the text "String not found". In the DicServiceImpl, before looking up the query string in the dictionary the thread should be put to sleep for a time, i.e. Tread.sleep(1000), to slow the service down and simulate a real asynchronous service.
