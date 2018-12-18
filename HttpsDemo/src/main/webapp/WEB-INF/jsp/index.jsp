
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>FirebaseUI Auth Demo</title>

    </head>
    <body>


        <div id="recaptcha-container"></div>
        <input type="submit" onclick="makeCall()">
        <script src="https://www.gstatic.com/firebasejs/5.5.6/firebase.js"></script>
        <script>
            // Initialize Firebase
            var config = {
                apiKey: "AIzaSyBnKnGWgDpJ0bPJdSJt5cf9dtglahykwIQ",
                authDomain: "fir-f347b.firebaseapp.com",
                databaseURL: "https://fir-f347b.firebaseio.com",
                projectId: "fir-f347b",
                storageBucket: "fir-f347b.appspot.com",
                messagingSenderId: "10412578289"
            };
            firebase.initializeApp(config);

            function makeCall() {

                window.recaptchaVerifier = new firebase.auth.RecaptchaVerifier('recaptcha-container', {
                    'size': 'normal',
                    'callback': function (response) {
                        console.log(response);
                    },
                    'expired-callback': function () {
                        // Response expired. Ask user to solve reCAPTCHA again.
                        // ...
                    }
                });

                alert("working");

                var phoneNumber = "+918477013437";
                var appVerifier = window.recaptchaVerifier;
                console.log("phoneNumber= " + phoneNumber + " appVerifier= " + appVerifier);
                alert("appVerifier= " + appVerifier);
                firebase.auth().signInWithPhoneNumber(phoneNumber, appVerifier)
                        .then(function (confirmationResult) {
                            console.log("RESPONSE");
                            console.log(confirmationResult);
                            window.confirmationResult = confirmationResult;
                        }).catch(function (error) {
                    console.log(error);
                    alert("error");
                });
            }
            makeCall();
        </script>

    </body>
</html>
