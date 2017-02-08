# bluemix-springboot-rabbitmq

### Build

```
mvn package
```

### Deploy

Change the `name` in manifest.yml.

```
cf push
```

Navigate to the app url, and add a paramter, e.g.

http://csnow-springboot2.mybluemix.net/greeting?name=Chris%20Snow2

### Monitor

```
cf env csnow-springboot2
```

E.g.


```
{
 "VCAP_SERVICES": {
  "compose-for-rabbitmq": [
   {
    "credentials": {
     ...
     "db_type": "rabbitmq",
     "uri_admin": "https://bluemix-sandbox-dal-9-portal5.dblayer.com:22914",
     "uri_direct_1": "amqps://USERNAME:PASSWORD@bluemix-sandbox-dblayer.com:22914/bmix_dal_12345"
    },
    ...
    ]
   }
  ]
 }
}
```

- Open `uri_admin` in a web browser.  
- Login with USERNAME and PASSWORD from `uri_direct_1`
- Navigate to `Queues`, then `q1`
- Click get Message(s).  You should see your message from the deploy step.

