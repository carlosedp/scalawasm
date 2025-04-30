# Dockerfile to deploy our app
FROM node:23-bookworm-slim

ARG MAINDIR=main.js

# Copy package.json and package-lock.json
COPY package*.json /

# Copy application source code
ADD $MAINDIR /main.js

# Run app
CMD ["npm", "run", "start"]
