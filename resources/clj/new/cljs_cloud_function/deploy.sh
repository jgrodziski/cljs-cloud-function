#!/bin/sh

REGION=europe-west1
BUCKET_NAME=my-bucket
source ./build.sh

echo "Deploy Cloud Function \"{{name}}\" in region $REGION"
# gcloud functions look for an `index.js` file and a `{{name}}` name in the module exports
#gcloud functions deploy {{name}} --region $REGION --entry-point function --runtime nodejs10 --trigger-resource $BUCKET_NAME --trigger-event google.storage.object.finalize
gcloud functions deploy {{name}} --region $REGION --runtime nodejs10 --trigger-http

if [[ $? -eq 0 ]]; then
    echo "Successfully deployed \"{{name}}\" Cloud Function"
else
    echo "Fail to deploy Cloud Function \"{{name}}\""
    exit 1
fi

