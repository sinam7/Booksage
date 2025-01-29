import { Component } from "@/components/component/component";
import { fetchBookstoreData } from "@/components/api/getBooks";

async function getInitialData() {
  const libraryData = await fetchBookstoreData('library', null);
  const kyoboData = await fetchBookstoreData('kyobo', null);
  const interparkData = await fetchBookstoreData('interpark', null);
  
  return {
    library: libraryData,
    kyobo: kyoboData,
    interpark: interparkData
  };
}

export default async function Home() {
  const initialData = await getInitialData();
  
  return (
    <Component initialData={initialData} />
  );
}
