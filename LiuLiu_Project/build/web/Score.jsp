<%-- 
    Document   : display-score
    Created on : Mar 13, 2024, 12:59:46 AM
    Author     : nocol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                .back-link {
                    display: inline-block;
                    margin-top: 20px;
                    text-decoration: none;
                    color: #fff;
                    background-color: #007bff;
                    padding: 10px 20px;
                    border-radius: 5px;
                    transition: background-color 0.3s, color 0.3s;
                }

                .back-link:hover {
                    background-color: #0056b3; /* Darker blue background on hover */
                }

                .back-link span {
                    margin-right: 5px;
                }




                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                background-color: #f0f0f0;
            }

            .score-container {
                font-size: 72px; /* Increase font size to make the score bigger */
                font-weight: bold;
                text-align: center;
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>
        <div class="score-container">
            Your Score: <span id="score"> ${corrected}/${total} </span>
        </div><br><br>
        <a href="HomeUser.jsp" class="back-link">
            <span>&#8592;</span> Back to Homepage
        </a>
    </body>
</html>
