<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
</head>
<body>
    <label><b>WELCOME EMPLOYEE!!</b></label>
    <label>Give the id and select the options you would like to modify and submit!!</label>
    <form action="modify">

    <label for="idval">ID:</label>
    <input type="text" id="idval" name="id"><br><br>
    <select name="projectname" id="projectname">
          <option value="Project1">Project1</option>
          <option value="Project2">Project2</option>
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
    <button type="submit" class="signupbtn">Modify</button><br><br>
    </form>
</body>
</html>