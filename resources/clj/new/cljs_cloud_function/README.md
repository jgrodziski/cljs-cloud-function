# NodeJS & environment prerequisites

Google Cloud Functions target node 10.15.3

To use multiple node versions on your dev machine you can use `nvm`

On Mac, Install nvm with: `brew install nvm` you'll have to add some env var in your .zshrc config

then `nvm install v10.15.3` and `nvm use 10.15.3`

Open a new shell and verify that node is at the version 10.15.3 with `node -v`

# Dev environment

## Start a NodeJS REPL in terminal

`shadow-cljs node-repl`
You can then connect to the nREPL server on the displayed port

## Build the JS artefact

Invoke the `build.sh` script.

## Run the test

`./test.sh`

to watch: `shadow-cljs watch test`

## Install JS libraries

You can install any Node JS library with `npm` and `shadow-cljs`, see: https://shadow-cljs.github.io/docs/UsersGuide.html#npm 

# Deployment

You should have the [gcloud SDK](https://cloud.google.com/sdk/gcloud/) installed on the machine on which you invoke the `deploy.sh` script.
Invoke the `./deploy.sh` shell script

# Invocation of the Cloud Function

You can then invoke the cloud function with:
```
curl -X GET "https://YOUR_REGION-YOUR_PROJECT_ID.cloudfunctions.net/FUNCTION*NAME" 
```
(FUNCTION*NAME is `myapp`` if you generate the project with: `clj -A:new cljs-cloud-function myname/myapp`)

# Troubleshooting

Beware of the .gcloudignore that is being fed with the .gitignore, if the index.js file is declared to be ignored it will not be send to gcloud and the deployment would fail.
Solution: remove from any .xignore file or do not feed the .gcloudignore with the .gitignore


