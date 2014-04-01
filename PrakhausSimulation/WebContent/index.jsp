<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="controller.Controller" %>
<%@ page import="logger.ArrayListLogger" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eventdriven Simulation</title>
</head>
<body>

<h1>Eventdriven Simulation of a parkhouse</h1>


<%!
	Controller con = new Controller(24.0,5,5,0,0,false,false,60,60);
	boolean ret=con.setTestResults();
	ArrayListLogger logger = con.giveResults();
	 ArrayList list;
%>


<table>
	<tr>
		<td>Entry Events</td>
		<%  list = logger.getEntryEventTimes();
		for (Object item:  list) {
			item = (Double) item;
			   System.out.println("<td>"+item+"</td>");
		}%>
	</tr>
	<tr>
		<td>Terminal Two Events</td>
		<%  list = logger.getTerminalOneEventTimes();
		for (Object item:  list) {
			item = (Double) item;
			   System.out.println("<td>"+item+"</td>");
		}%>
	</tr>
	<tr>
		<td>Terminal One Events</td>
		<%  list = logger.getTerminalTwoEventTimes();
		for (Object item:  list) {
			item = (Double) item;
			   System.out.println("<td>"+item+"</td>");
		}%>
	</tr>
	<tr>
		<td>Parkend Events</td>
		<%  list = logger.getParkEndEventTimes();
		for (Object item:  list) {
			item = (Double) item;
			   System.out.println("<td>"+item+"</td>");
		}%>
	</tr>
	<tr>
		<td>Queue One</td>
		<%  list = logger.getQueueOneCounts();
		for (Object item:  list) {
			item = (Integer) item;
			   System.out.println("<td>"+item+"</td>");
		}%>
	</tr>
	<tr>
		<td>Queue Two</td>
		<%  list = logger.getQueueTwoCounts();
		for (Object item:  list) {
			item = (Integer) item;
			   System.out.println("<td>"+item+"</td>");
		}%>
	</tr>
	<tr>
		<td>Freeslots</td>
		<%  list = logger.getFreeSlotsCounts();
		for (Object item:  list) {
			item = (Integer) item;
			   System.out.println("<td>"+item+"</td>");
		}%>
	</tr>
	<tr>
		<td>Terminal One States</td>
		<%  list = logger.getTerminalOneStates();
		for (Object item:  list) {
			item = (Boolean) item;
			   System.out.println("<td>"+item+"</td>");
		}%>
	</tr>
	<tr>
		<td>Terminal Two States</td>
		<%  list = logger.getTerminalTwoStates();
		for (Object item:  list) {
			item = (Boolean) item;
			   System.out.println("<td>"+item+"</td>");
		}%>
	</tr>
	<tr>
		<td>Simulation Time</td>
		<%  list = logger.getSimulationTime();
		for (Object item:  list) {
			item = (Double) item;
			   System.out.println("<td>"+item+"</td>");
		}%>
	</tr>
	
</table>

</body>
</html>