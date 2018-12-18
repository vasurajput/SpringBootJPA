/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

// This config file is for the demo only. It is in .gitignore and will not be pushed to git repo.
var config = {
  apiKey: "AIzaSyBgcSHxbo93P-N9Sh-ZIqgzvwicHDk_Skc",
  authDomain: "fir-ui-demo-84a6c.firebaseapp.com",
  databaseURL: "https://fir-ui-demo-84a6c.firebaseio.com",
  storageBucket: "fir-ui-demo-84a6c.appspot.com",
};
firebase.initializeApp(config);

// Google OAuth Client ID, needed to support One-tap sign-up.
// Set to null if One-tap sign-up is not supported.
var CLIENT_ID =
    '265939374336-cj26lol6s990fq9fp4s0ri86si3rj86n.apps.googleusercontent.com';