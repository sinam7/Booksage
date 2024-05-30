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
}

export interface BookProps {
    title: string;
    author: string;
    company: string;
    price: string;
    link: string;
    imageSrc: string;
}

export function BookColumn({name, query, displayName}: BookColumnProps) {
    const [data, setData] = useState<BookProps[]>([]);
    const [error, setError] = useState<string | null>(null);
    const [loading, setLoading] = useState<boolean>(true);

    useEffect(() => {
        const getData = async () => {
            try {
                setLoading(true);
                console.log(name, query);
                const result = await fetchBookstoreData(name, query);
                setData(result);
            } catch (err: any) {
                setError(err.message);
            } finally {
                setLoading(false);
            }
        };

        getData();
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

    const cardContent =
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
    ;

    return (
        <div className="space-y-4 border-r pr-8">
            <h2 className="text-2xl font-bold">{displayName}</h2>
            <Card>
                <CardContent className="space-y-2 mt-4">
                    {/*{loadingComponent}*/}
                    {loading ? loadingComponents : cardContent}
                </CardContent>
            </Card>
        </div>
    );
}