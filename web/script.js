document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('calculate:slideR_hidden').addEventListener('change', function () {
        if (checkR(false)) draw();
        isDrawn = true;
        hideWarning();
    });
    document.querySelector('calculate:slideR').addEventListener('click', function () {
        console.log('ekgekger');
        if (checkR(false)) { draw();
            isDrawn = true;
            hideWarning();
        }
    });
    document.getElementById('computed_result').addEventListener('click', pickPoint);
    //document.getElementById('send').addEventListener('click', check);

    let canvas = document.getElementById('result');
    canvas.width = 1000;
    canvas.height = 1000;
    let width = window.getComputedStyle(document.getElementById('computed_result')).width;
    console.log("default = " + width);
});


let x, y, r, isDrawn;

function check(btn) {
    // btn.preventDefault();

    if (checkR() & checkX() & checkY()) {
        draw();
        drawDot(x / r * 400 + 500, -y / r * 400 + 500);
        //compute();
        $("#calculate\\:sender").click();
    }
}

function checkY() {
    let passed = true;
    let min = -5;
    let max = 5;
    y = $("[id$='Y']").val();
    y = y.replace(",", ".");
    if (isNaN(y) || Number(y) <= min || Number(y) >= max || y === '') {
        document.getElementById("Y_input").classList.add("error");
        document.getElementById("Y_comment").classList.replace("ok_comment", "error_comment");
        passed = false;
    }
    else {
        document.getElementById("Y_input").classList.remove("error");
        document.getElementById("Y_comment").classList.replace("error_comment", "ok_comment");
    }
    return passed;
}

function checkX() {
    let passed = true;
    x = document.getElementById('calculate:X_input').value;
    let min = -3;
    let max = 3;
    if (isNaN(x) || Number(x) <= min || Number(x) >= max || x === '') {
        document.getElementById("X_input").classList.add("error");
        document.getElementById("X_comment").classList.replace("ok_comment", "error_comment");
        passed = false;
    }
    else {
        document.getElementById("X_input").classList.remove("error");
        document.getElementById("X_comment").classList.replace("error_comment", "ok_comment");
    }
    return passed;
}

function checkR(change = true) {
    let passed = true;
    let min = 2;
    let max = 5;
    let R = document.getElementById("calculate:slideR_hidden").value;
    R = R.replace(",", ".");
    if (isNaN(R) || Number(R) <= min || Number(R) >= max || R === '') {
        if (change) {
            document.getElementById("R_input").classList.add("error");
            document.getElementById("R_comment").classList.replace("ok_comment", "error_comment");
        }
        passed = false;
    }
    else {
        document.getElementById("R_input").classList.remove("error");
        document.getElementById("R_comment").classList.replace("error_comment", "ok_comment");
    }
    if (passed) r = R;
    return passed;
}

function pickPoint(event) {
    if (isDrawn) {
        let canvas = document.getElementById('computed_result');
        console.log("click X = " + event.pageX + "\nclick Y = " + event.pageY + "\nscroll X = "
            + window.pageXOffset + "\nscroll Y = " + window.pageYOffset
            + "\n canvas X = " + canvas.getBoundingClientRect().left + "\n canvas Y = "
            + canvas.getBoundingClientRect().top);
        let X = event.pageX - canvas.getBoundingClientRect().left;
        let Y = event.pageY - (canvas.getBoundingClientRect().top + window.pageYOffset);
        let blockWidth = parseInt(window.getComputedStyle(document.getElementById('computed_result')).width);
        X = X / blockWidth * 1000;
        Y = Y / blockWidth * 1000;
        x = (X - 500) / 400 * r;
        y = -(Y - 500) / 400 * r;
        console.log(" draw X = " + X + " draw Y = " + Y);
        drawDot(X, Y);
        compute();
    } else showWarning();
}

function showWarning() {
    let warning = document.getElementById("warning");
    warning.style.display = "block";
    warning.style.top = document.getElementById("script_output").getBoundingClientRect().top + window.pageYOffset;
    $("#warning").animate({
        left: "80%"
    }, 700);
}

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

function hideWarning() {
    $("#warning").animate({
        left: "100%"
    }, 1000);
    sleep(1000);
    document.getElementById("warning").style.display = "none";
}

function draw() {
    let canvas = document.getElementById("result");
    let context = canvas.getContext("2d");
    let width = canvas.width;
    let height = canvas.height;
    drawArea(canvas, context, width, height);
    drawLines(canvas, context, width, height);
}

function drawLines(canvas, context, width, height) {
    context.fillStyle = "black";
    context.font = "normal normal normal 16px arial";
    context.beginPath();
    context.moveTo(width / 2, height);
    context.lineTo(width / 2, 0);
    context.fillText("  Y", width * 0.52, height * 0.03);
    context.lineTo(width / 2 - width * 0.01, width * 0.03);
    context.moveTo(width / 2, 0);
    context.lineTo(width / 2 + width * 0.01, width * 0.03);
    context.moveTo(0, height / 2);
    context.lineTo(width, height / 2);
    context.fillText("X", width * 0.97, height * 0.53);
    context.lineTo(width - width * 0.03, height / 2 - height * 0.01);
    context.moveTo(width, height / 2);
    context.lineTo(width - width * 0.03, height / 2 + height * 0.01);

    context.moveTo(width * 0.1, height / 2 + height * 0.01);
    context.lineTo(width * 0.1, height / 2 - height * 0.01);
    context.fillText(-r, width * 0.1, height * 0.53);

    context.moveTo(width * 0.3, height / 2 + height * 0.01);
    context.lineTo(width * 0.3, height / 2 - height * 0.01);
    context.fillText(-r / 2, width * 0.3, height * 0.53);

    context.fillText(0, width * 0.51, height * 0.53);

    context.moveTo(width * 0.7, height / 2 + height * 0.01);
    context.lineTo(width * 0.7, height / 2 - height * 0.01);
    context.fillText(r / 2, width * 0.7, height * 0.53);

    context.moveTo(width * 0.9, height / 2 + height * 0.01);
    context.lineTo(width * 0.9, height / 2 - height * 0.01);
    context.fillText(r, width * 0.9, height * 0.53);

    context.moveTo(width / 2 + width * 0.01, height * 0.1);
    context.lineTo(width / 2 - width * 0.01, height * 0.1);
    context.fillText(r, width * 0.53, height * 0.1);

    context.moveTo(width / 2 + width * 0.01, height * 0.3);
    context.lineTo(width / 2 - width * 0.01, height * 0.3);
    context.fillText(r / 2, width * 0.53, height * 0.3);

    context.moveTo(width / 2 + width * 0.01, height * 0.7);
    context.lineTo(width / 2 - width * 0.01, height * 0.7);
    context.fillText(-r / 2, width * 0.53, height * 0.7);

    context.moveTo(width / 2 + width * 0.01, height * 0.9);
    context.lineTo(width / 2 - width * 0.01, height * 0.9);
    context.fillText(-r, width * 0.53, height * 0.9);

    context.closePath();
    context.strokeStyle = "black";
    context.stroke();
}

function drawArea(canvas, context, width, height) {
    context.clearRect(0, 0, width, height);
    context.fillStyle = "#3399ff";
    context.fillRect(width * 0.3, height / 2, width * 0.2, height * 0.4);
    context.beginPath();
    context.moveTo(width * 0.5, height * 0.1);
    context.lineTo(width * 0.7, height * 0.5);
    context.lineTo(width * 0.5, height * 0.5);
    context.fill();
    context.beginPath();
    context.arc(width / 2, height / 2, width * 0.2, Math.PI, 0, true);
    context.fill();
}

function drawDot(X, Y) {
    let canvas = document.getElementById("result");
    let context = canvas.getContext("2d");
    let radius = canvas.width / 100;
    let red = Math.random() * 255;
    let green = Math.random() * 255;
    let blue = Math.random() * 255;
    context.fillStyle = 'rgb(' + red + ', ' + green + ', ' + blue + ')';
    console.log("X = " + X + " Y = " + Y);
    context.fillRect(X, Y, radius, radius);
}

function compute() {
    drawDot();
    x = Number(x).toFixed(2);
    y = Number(y).toFixed(2);
    r = Number(r).toFixed(2);
    $.ajax({
        url: 'control',
        type: 'GET',
        data: {X: x, Y: y, R: r},
        success: function (data) {
            console.log(x + " " + y + " " + r + ";\n");
            let start = data.lastIndexOf("<td>") + 4;
            let end = data.lastIndexOf("</td>");
            let answer = data.substring(start, end);
            if (answer === "Incorrect values were sent") {
                let table = $(document).find("#table_result");
                let row = $("<tr/>");
                let cell = $("<td colspan='4'/>").text("Отправленные данные некорректны");
                row.append(cell);
                table.append(row);
                return;
            }
            console.log(answer);
            let table = document.getElementById("table_result");
            let row = document.createElement("tr");
            let cellX = document.createElement("td");
            let cellY = document.createElement("td");
            let cellR = document.createElement("td");
            let cellAnswer = document.createElement("td");
            let htmlX = document.createTextNode(x);
            let htmlY = document.createTextNode(y);
            let htmlR = document.createTextNode(r);
            let htmlAnswer = document.createTextNode(answer);
            cellX.appendChild(htmlX);
            cellY.appendChild(htmlY);
            cellR.appendChild(htmlR);
            cellAnswer.appendChild(htmlAnswer);
            row.appendChild(cellX);
            row.appendChild(cellY);
            row.appendChild(cellR);
            row.appendChild(cellAnswer);
            table.append(row);
        },
        error: function () {
            let table = $(document).find("#table_result");
            let row = $("<tr/>");
            let cell = $("<td colspan='4'/>").text("Произошла ошибка");
            row.append(cell);
            table.append(row);
        }
    });
}
