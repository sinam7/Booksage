import React, {Dispatch, SetStateAction, useEffect, useState} from 'react';

interface HistoryBarProps {
    handleSearch: () => void;
    history: string[];
    setHistory: Dispatch<SetStateAction<string[]>>;
    setQuery: React.Dispatch<React.SetStateAction<string>>;
}


export function HistoryBar({handleSearch, history, setHistory, setQuery}: HistoryBarProps) {

    const [clickedItem, setClickedItem] = useState<string | null>(null);

    const click = (item: string) => {
        setClickedItem(item);
        setQuery(item);
    };

    useEffect(() => {
        if (clickedItem !== null) {
            handleSearch();
            setClickedItem(null);  // Reset clickedItem to avoid repetitive calls
        }
    }, [clickedItem, handleSearch]);



    return (
        <div style={{display: 'flex', flexDirection: 'row'}} className="text-gray-900 dark:text-gray-100">
            {history.length != 0 && <span>Recent:</span>}
            {history.map((item, index) => (
                <div
                    key={index}
                    className="mx-2 cursor-pointer underline text-blue-600 dark:text-blue-400 hover:text-blue-800 dark:hover:text-blue-300 min-w-[100px] text-center"
                    onClick={(e) => click(item)}>
                    {item}
                </div>
            ))}
        </div>
    );
};

export default HistoryBar;
