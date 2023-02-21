import fetch from 'unfetch';

const checkStatus = response => {
    if (response.ok) {
        return response;
    }
    // convert non-2xx HTTP responses into errors:
    const error = new Error(response.statusText);
    console.log("Error here");
    error.response = response;
    return Promise.reject(error);
}

export const getAllUsers = () =>
    fetch("api/v1/users")
        .then(checkStatus);