export const getActivities = async (keyword: string) => {
    return await fetch('http://localhost:9595/activities?keyword='+keyword, {
        method: "GET",
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json',
        },
    }).then((response) => {
        return {'status': true, data: response.json()};
    }).catch((error) => {
        return  {status: false, message: error.message ?? 'an error occurred'};
    });
}
