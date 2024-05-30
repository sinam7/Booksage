export const fetchBookstoreData = async (name: string, query: string | null): Promise<any> => {
    const url = `http://localhost:8080/api/bookstore/${name}` + (!query ? "" : "/search?query="+query);

    console.log(url);
    try {
        const response = await fetch(url, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }

        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Error fetching data:', error);
        throw error;
    }
};