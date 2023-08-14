<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form action="/sample/exUploadPost" method="post" enctype="multipart/form-data">
	<div>
		<input type="file" name="files" />
	</div>
	<div>
		<input type="file" name="files" />
	</div>
	<div>
		<input type="file" name="files" />
	</div>
	<div>
		<input type="file" name="files" />
	</div>
	<div>
		<input type="file" name="files" />
	</div>
	
	<div>
		<input type="submit" /> <!-- value값 지정하지 않았을 경우 '제출'로 출력됨 -->
	</div>
</form>

</body>
</html>