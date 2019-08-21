# cljs-cloud-function

A cljs template to create a project using tools.deps and shadow-cljs targeting Google Cloud Function serverless environment for execution.

## Usage

```
clj -Sdeps '{:deps {seancorfield/clj-new {:mvn/version "0.7.7"}}}' \
  -m clj-new.create \
  cljs-cloud-function \
  myname/myapp
```

Or if you have `clj-new` in your `~/.clojure/deps.edn` like so:

```
{:aliases {:new {:extra-deps {seancorfield/clj-new {:mvn/version "0.7.7"}}
                 :main-opts ["-m" "clj-new.create"]}}
 ...}
```

just invoke: 
```
clj -A:new cljs-cloud-function myname/myapp
```

Then you can edit the .../foo.cljs namespace and the `myapp` function inside.
You can just invoke the build with `build.sh`.
Then `deploy.sh` (will invoke the `build.sh` script first), given you had installed the [`gcloud SDK`](https://cloud.google.com/sdk/gcloud/) and had loggued onto your project.

You can install any Node JS library with `npm` and `shadow-cljs`, see: https://shadow-cljs.github.io/docs/UsersGuide.html#npm 

See [clj-new](https://github.com/seancorfield/clj-new) for invoking the clj-new.create function with the template. 

## License

Copyright © 2019 Jeremie Grodziski

Distributed under the Eclipse Public License either version 1.0.
