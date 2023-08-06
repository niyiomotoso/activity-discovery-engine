# Use the official Node.js 16 image as the base image
FROM node:16-alpine

RUN apk update && apk add python3

# Set the working directory inside the container
WORKDIR /app
# Copy the rest of the app's source code
COPY . .

# Install app dependencies
RUN npm install

# Expose the port that the Vue.js app listens on
EXPOSE 8080

# Command to run the Vue.js app in development mode
CMD ["npm", "run", "serve"]
