
<!DOCTYPE html>
<html lang="en">

    <p>${records[0].id}</p>
    <p>${records[0].projectname}</p>
    <c:forEach items="${records}" var="item">
        <p><h1>${item}<br></h1></p>
    </c:forEach>    
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,
         initial-scale=1.0">
         <title> Records</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    </head>
    <body>
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
                <th>Acceptance</th>
              </tr>
            </thead>
              <c:forEach items="${records}" var="record">
                <tr>
                    <td>${record.id}</td>
                </tr>
              </c:forEach>
          </table>
        </div>
    </body>
</html>