<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
<title>Kalkulator</title>
</head>
<body>

<jsp:useBean id="calc" class="atj.Calc" scope="session"></jsp:useBean>

<table class="title"><tr><td colspan="5" class="titletd">JSP Calculator</td></tr></table>
<form method="post">
<table>
<tr>
	<td colspan="4" class="resultdetails">${calc.resultDetails}</td>
	<td rowspan="2"><input type="submit" name="btn" value="C" class="calcbutton"></td>
</tr>
<tr>
	<td colspan="4" class="result">${calc.result}</td>
</tr>
<tr>
	<td><input type="submit" name="btn" value="7" class="calcbutton"></td>
	<td><input type="submit" name="btn" value="8" class="calcbutton"></td>
	<td><input type="submit" name="btn" value="9" class="calcbutton"></td>
	<td><input type="submit" name="action" value="/" class="calcbutton"></td>
	<td><input type="submit" name="action" value="sqrt" class="calcbutton"></td>
</tr>
<tr>
	<td><input type="submit" name="btn" value="4" class="calcbutton"></td>
	<td><input type="submit" name="btn" value="5" class="calcbutton"></td>
	<td><input type="submit" name="btn" value="6" class="calcbutton"></td>
	<td><input type="submit" name="action" value="*" class="calcbutton"></td>
	<td><input type="submit" name="action" value="%" class="calcbutton"></td>
</tr>
<tr>
	<td><input type="submit" name="btn" value="1" class="calcbutton"></td>
	<td><input type="submit" name="btn" value="2" class="calcbutton"></td>
	<td><input type="submit" name="btn" value="3" class="calcbutton"></td>
	<td><input type="submit" name="action" value="-" class="calcbutton"></td>
	<td rowspan="2"><input type="submit" name="equals" value="=" class="equalcalcbutton"></td>
</tr>
<tr>
	<td><input type="submit" name="btn" value="0" class="calcbutton"></td>
	<td><input type="submit" name="btn" value="," class="calcbutton"></td>
	<td><input type="submit" name="action" value="+/-" class="calcbutton"></td>
	<td><input type="submit" name="action" value="+" class="calcbutton"></td>
</tr>
</table>
</form>

</body>
</html>