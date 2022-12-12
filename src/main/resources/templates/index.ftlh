[#ftl]
<!doctype html>
<html lang="cs">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Budou už Vánoce?</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Rubik+Gemstones&display=swap');

        html {
            box-sizing: border-box;
        }

        *, *::before, *::after {
            box-sizing: inherit;
        }

        body {
            font: 96px 'Rubik Gemstones', cursive;
            text-shadow: 1px 1px 4px black;
            color: white;
            margin: 0;
            padding: 0;
            height: 100vh;
            background: #47382F url(https://source.unsplash.com/SUTfFCAHV_A) center center/cover no-repeat;
        }

        div {
            height: 100vh;
            display: grid;
            place-items: center;
            text-align: center;
        }
    </style>
</head>
<body>
[#if christmas == 0]
    <div>Vánoce jsou dnes!</div>
[#elseif christmas == 1]
    <div>Vánoce budou zítra.</div>
[#elseif christmas == 2]
    <div>Vánoce budou pozítří.</div>
[#elseif christmas gte 3 && christmas lte 4]
    <div>Vánoce budou za ${christmas} dny.</div>
[#elseif christmas gt 100]
    <div>Vánoce budou až za dlouho…</div>
[#else]
    <div>Vánoce budou za ${christmas} dnů.</div>
[/#if]
</body>
</html>
