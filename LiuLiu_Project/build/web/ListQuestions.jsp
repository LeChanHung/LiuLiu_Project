<%-- 
    Document   : list-question
    Created on : Mar 12, 2024, 8:11:05 PM
    Author     : nocol
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>
        <title>JSP Page</title>
        <style>
            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
                padding: 20px;
            }

            .question-container {
                margin-bottom: 30px;
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                padding: 20px;
            }

            .question-container h3 {
                margin-bottom: 15px;
                font-size: 22px;
                color: #333;
            }

            .choice-columns--1 {
                display: flex;
                flex-wrap: wrap;
            }

            .c-choice-option {
                margin-right: 20px;
                margin-bottom: 10px;
            }

            .c-choice-option label {
                display: flex;
                align-items: center;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            .c-choice-option label:hover {
                background-color: #f5f5f5;
            }

            .c-choice-option input[type="radio"] {
                margin-right: 10px;
            }

            .btn-primary {
                background-color: #007bff;
                color: #fff;
                padding: 12px 24px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px;
                transition: background-color 0.3s ease;
            }

            .btn-primary:hover {
                background-color: #0056b3;
            }

            /* Responsive CSS */
            @media (max-width: 768px) {
                .question-container {
                    padding: 15px;
                }

                .c-choice-option {
                    margin-right: 15px;
                }
            }
        </style>
        <script>
            function validateForm() {
                var checkbox = document.getElementById("confirmationCheckbox");
                if (!checkbox.checked) {
                    alert("Hãy xác nhận bạn muốn submit!");
                    return false; // Ngăn chặn việc submit form
                }
                return true; // Cho phép submit form nếu checkbox đã được chọn
            }
        </script>
    </head>
    <body>
        <form method="post" action="listquestion" onsubmit="return validateForm()">
            <c:forEach items="${question}" var="q" varStatus="loop">
                <div tabindex="0" class="c-forms-layout-element c-field c-forms-layout-field">
                    <div class="c-label c-field-label">
                        <p><i class="fas fa-band-aid"></i><h3>*Question ${loop.index +1}:</h3></p>
                        <div class="c-icons">${q.text}</div>
                    </div>
                    <div class="c-editor">
                        <div class="choice-columns--1">
                            <div class="c-choice-option">
                                <label
                                    ><input tabindex="-1" type="radio" name="answer${loop.index}" value="${q.op1}"/><span
                                        >${q.op1}&nbsp;&nbsp;</span
                                    ></label
                                >
                            </div>
                            <div class="c-choice-option">
                                <label
                                    ><input tabindex="-1" type="radio" name="answer${loop.index}" value="${q.op2}"/><span
                                        >${q.op2}&nbsp;&nbsp;</span
                                    ></label
                                >
                            </div>
                            <div class="c-choice-option">
                                <label
                                    ><input tabindex="-1" type="radio" name="answer${loop.index}" value="${q.op3}"/><span
                                        >${q.op3}&nbsp;&nbsp;</span
                                    ></label
                                >
                            </div>
                            <div class="c-choice-option">
                                <label
                                    ><input tabindex="-1" type="radio" name="answer${loop.index}" value="${q.op4}"/><span
                                        >${q.op4}&nbsp;&nbsp;</span
                                    ></label
                                >
                            </div>
                        </div>
                    </div>
                    <div class="c-helptext c-html" style="display: none" aria-hidden=""></div>
                    <div class="c-col-resizer"></div>
                    <div style="" class="c-quick-insert">
                        <div class="plus"><i class="icon-plus"></i></div>
                        <div class="line"></div>
                    </div>
                </div>

                <input type="hidden" name="question${loop.index}" value="${q.answer}">
            </c:forEach>
            <br>
            <!--                <input type="checkbox" name="check" value="submit">  I want to submit !!<br>-->
            <input type="checkbox" name="confirmationCheckbox" id="confirmationCheckbox">
            <label for="confirmationCheckbox">I confirm</label>
            <button class="btn-primary" style="size: 100px">Submit</button>
        </form>
    </body>
</html>
