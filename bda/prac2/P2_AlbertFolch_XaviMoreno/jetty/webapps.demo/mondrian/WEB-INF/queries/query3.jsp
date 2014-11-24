<%@ page session="true" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="http://www.tonbeller.com/jpivot" prefix="jp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>


<jp:mondrianQuery id="query01" 
	jdbcDriver="org.postgresql.Driver"
	jdbcUrl="jdbc:postgresql://postgres.mat.ub.edu/afolchga8"
	catalogUri="/WEB-INF/queries/PrivaliaUB.xml"
	jdbcUser="afolchga8_adm"
	jdbcPassword="654321"
	connectionPooling="false">

select {[Import]} on columns,
 [Usuari].[All Usuari] on rows
 from cub where ([Talla].[xs], [Edat].[39])


</jp:mondrianQuery>

<c:set var="title01" scope="session">4 hierarchies on one axis</c:set>
