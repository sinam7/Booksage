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
        <div style={{display: 'flex', flexDirection: 'row'}}>
            {history.length != 0 && <span>Recent:</span>}
            {history.map((item, index) => (
                <div
                    key={index}
                    style={{
                        margin: '0 10px',
                        cursor: 'pointer',
                        textDecoration: 'underline',
                        color: 'blue',
                        width: 'fit-content',
                        minWidth: '100px',
                        textAlign: 'center'
                    }}
                    onClick={(e) => click(item)}>
                    {item}
                </div>
            ))}
        </div>
    );
};

export default HistoryBar;
