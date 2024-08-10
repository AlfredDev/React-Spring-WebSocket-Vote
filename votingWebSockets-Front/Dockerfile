# Base image
FROM node:14 as build

# Set working directory
WORKDIR /app

# Add `/app/node_modules/.bin` to $PATH
ENV PATH /app/node_modules/.bin:$PATH

# Install and cache app dependencies
COPY package.json /app/package.json
RUN npm install
RUN npm install react-scripts@3.4.1 -g

# Add app
COPY . /app

# Build the app
RUN npm run build

# Production image, copy all the files and run nginx
FROM nginx:alpine
COPY --from=build /app/build /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
