"use client"
import {Card, CardContent} from "@/components/ui/card";
import React, {useEffect, useState} from "react";
import {BookCard} from "@/components/component/bookCard";
import {fetchBookstoreData} from "@/components/api/getBooks";
import Skeleton from 'react-loading-skeleton'
import 'react-loading-skeleton/dist/skeleton.css'


interface BookColumnProps {
    name: string;
    query: string | null;
    displayName: string;
    initialData: BookProps[];
}

export interface BookProps {
    title: string;
    author: string;
    company: string;
    price: string;
    link: string;
    imageSrc: string;
}

const NoResultsIcon = () => (
    <svg
        className="w-32 h-32 text-red-500 mx-auto mb-6"
        viewBox="0 0 100 100"
        fill="none"
        stroke="currentColor"
        strokeWidth="4"
        strokeLinecap="round"
        strokeLinejoin="round"
    >
        <path
            d="M50 10 
               A5 5 0 0 1 55 13
               L90 75
               A5 5 0 0 1 85 82
               H15
               A5 5 0 0 1 10 75
               L45 13
               A5 5 0 0 1 50 10Z"
        />
        <path
            className="fill-current"
            transform="translate(31, 35) scale(0.04)"
            d="M502.29,788.199h-47c-33.1,0-60,26.9-60,60v64.9c0,33.1,26.9,60,60,60h47c33.101,0,60-26.9,60-60v-64.9
                C562.29,815,535.391,788.199,502.29,788.199z
                M170.89,285.8l86.7,10.8c27.5,3.4,53.6-12.4,63.5-38.3c12.5-32.7,29.9-58.5,52.2-77.3c31.601-26.6,70.9-40,117.9-40
                c48.7,0,87.5,12.8,116.3,38.3c28.8,25.6,43.1,56.2,43.1,92.1c0,25.8-8.1,49.4-24.3,70.8c-10.5,13.6-42.8,42.2-96.7,85.9
                c-54,43.7-89.899,83.099-107.899,118.099c-18.4,35.801-24.8,75.5-26.4,115.301c-1.399,34.1,25.8,62.5,60,62.5h49
                c31.2,0,57-23.9,59.8-54.9c2-22.299,5.7-39.199,11.301-50.699c9.399-19.701,33.699-45.701,72.699-78.1
                C723.59,477.8,772.79,428.4,795.891,392c23-36.3,34.6-74.8,34.6-115.5c0-73.5-31.3-138-94-193.4c-62.6-55.4-147-83.1-253-83.1
                c-100.8,0-182.1,27.3-244.1,82c-52.8,46.6-84.9,101.8-96.2,165.5C139.69,266.1,152.39,283.5,170.89,285.8z"
        />
    </svg>
);

export function BookColumn({name, query, displayName, initialData}: BookColumnProps) {
    const [data, setData] = useState<BookProps[]>(initialData);
    const [error, setError] = useState<string | null>(null);
    const [loading, setLoading] = useState<boolean>(false);

    useEffect(() => {
        if (query) {
            const getData = async () => {
                try {
                    setLoading(true);
                    const result = await fetchBookstoreData(name, query);
                    setData(result);
                } catch (err: any) {
                    setError(err.message);
                } finally {
                    setLoading(false);
                }
            };
            getData();
        }
    }, [name, query]);

    // @ts-ignore
    const loadingComponent = (idx) => {

        return <Card key={idx}>
            <div className="flex items-center justify-between mx-4 my-3">
                <div className="flex items-center gap-4">
                    <span className={"bold"}>{idx + 1}</span>
                    <Skeleton
                        className="rounded-md"
                        height={48}
                        style={{
                            aspectRatio: "48/48",
                            objectFit: "cover",
                        }}
                        width={48}
                    />
                    <div className="space-y-1">
                        <Skeleton width={"120px"} height={"24px"}/>
                        <div className="text-sm text-gray-500 dark:text-gray-400">
                            <Skeleton width={"100px"} height={"16px"} inline={true}/>
                            <span className="mx-2">•</span>
                            <Skeleton width={"100px"} height={"16px"} inline={true}/>
                            <br/>
                            <Skeleton width={"40px"} height={"16px"}/>
                        </div>
                    </div>
                </div>
            </div>
        </Card>
            ;
    }

    let loadingComponents = [];
    for (let i = 0; i < 10; i++) {
        loadingComponents.push(loadingComponent(i));
    }

    const cardContent = data.length > 0 ? (
        data.map((content: BookProps, idx: number) => (
            <BookCard key={idx}
                     idx={idx}
                     title={content.title}
                     author={content.author}
                     publisher={content.company}
                     price={content.price}
                     imageSrc={content.imageSrc}
                     href={content.link}
                     isAvailable={true}/>
        ))
    ) : (
        <div className="flex flex-col justify-center items-center h-60 text-gray-500 dark:text-gray-400">
            <NoResultsIcon />
            <p className="text-center">
                조회 결과가 없습니다.
                <br />
                검색어를 변경하시거나, 사이트의 상태를 확인해 주세요.
            </p>
        </div>
    );

    return (
        <div className="space-y-4 border-r border-gray-200 dark:border-gray-800 pr-8">
            <h2 className="text-2xl font-bold text-gray-900 dark:text-gray-100">{displayName}</h2>
            <Card>
                <CardContent className="space-y-2 mt-4">
                    {/*{loadingComponent}*/}
                    {loading ? loadingComponents : cardContent}
                </CardContent>
            </Card>
        </div>
    );
}