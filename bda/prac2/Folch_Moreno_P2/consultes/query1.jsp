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
 [Producte].[All producte] on rows
 from cub where ([Data].[2000].[4-2000], [Color].[groc], [Talla].[l])


</jp:mondrianQuery>

<c:set var="title01" scope="session">4 hierarchies on one axis</c:set>
