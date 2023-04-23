
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,
         initial-scale=1.0">
         <title> Records</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    </head>
    <body>
      <form> <a href="ModifyLogs.jsp">Modify Records</a></form><br><br>
      <form> <a href="DeleteLogs.jsp">Delete Records</a></form><br><br>
        <h1 class="text-center"> Slot Entries</h1>
        <div class="container">
        <table class="table table-bordered">
            <thead class="table-dark">
              <tr>
                <th>Id</th>
                <th>Project Name</th>
                <th>Lifecycle Step</th>
                <th>Effort Category</th>
                <th>Plan</th>
                <th>Start Date</th>
                <th>End Date</th>
                
              </tr>
            </thead>
              <c:forEach items="${records}" var="record">
                <tr>
                    <td>${record.id}</td>
                    <td>${record.projectname}</td>
                    <td>${record.lifecyclestep}</td>
                    <td>${record.effortcategory}</td>
                    <td>${record.plan}</td>
                    <td>${record.startdate}</td>
                    <td>${record.enddate}</td>
                    
                </tr>
              </c:forEach>
          </table>
        </div>
    </body>
</html>