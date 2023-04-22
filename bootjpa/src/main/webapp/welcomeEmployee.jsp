<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
</head>
<body>
    <label><b>WELCOME EMPLOYEE!!</b></label>
    <label>Click START button before the beginning of the task and click STOP button after it is done!!</label>
    <form action="starttimer"> <button type="submit" class="signupbtn">START the timer</button></form><br><br>
    <form action="endtimer">
    <select name="projectname" id="projectname">
          <option value="Project1">Project1</option>
          <option value="Project1">Project2</option>
        </select><br><br>
    <select name="lifecyclestep" id="lifecyclestep">
              <option value="lifecyclestep1">lifecyclestep1</option>
              <option value="lifecyclestep2">lifecyclestep2</option>
            </select><br><br>
    <select name="effortcategory" id="effortcategory">
                  <option value="effortcategory1">effortcategory1</option>
                  <option value="effortcategory2">effortcategory2</option>
                </select><br><br>
    <select name="plan" id="plan">
                      <option value="plan1">plan1</option>
                      <option value="plan2">plan2</option>
                    </select><br><br>
    <button type="submit" class="signupbtn">STOP the timer</button><br><br>
    </form>
    <label>Check the saved Logs over here</label>
    <form><a href="http://localhost:8080/fetchrecords">Fetch Records</a></form><br><br>
</body>
</html>