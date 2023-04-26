// dev.groovy
def config = [
        MONGODB_URI: 'mongodb://dev_mongo_username:dev_mongo_pwd@host.docker.internal:27018/?authSource=admin\\&tls=false',
        APP_ENV: 'dev',
        DEV_NGINX_PORT:'81'
]
return config
